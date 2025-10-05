package me.marcelberger.homepage.backend.service.jsonfilter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.exception.HpException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HpJsonFilterServiceImpl implements HpJsonFilterService {

    private final ObjectMapper objectMapper;

    @Override
    public String removeProperty(String inputJson, String property) {
        try {
            JsonNode rootNode = objectMapper.readTree(inputJson);
            if (rootNode instanceof ObjectNode o) {
                removePropertyRecursive(o, property);
            }
            return objectMapper.writeValueAsString(rootNode);
        } catch (Exception e) {
            throw new HpException(HpException.Code.HP0004, property, e.getMessage());
        }
    }

    private void removePropertyRecursive(ObjectNode node, String propertyToRemove) {
        if (node.has(propertyToRemove)) {
            node.remove(propertyToRemove);
        }
        node.fieldNames().forEachRemaining(field -> {
            JsonNode child = node.get(field);
            if (child.isObject()) {
                removePropertyRecursive((ObjectNode) child, propertyToRemove);
            }
        });
    }
}
