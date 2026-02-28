package me.marcelberger.homepage.backend.service.jsonfilter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HpJsonFilterServiceImpl implements HpJsonFilterService {

    private final ObjectMapper objectMapper;

    private final HpStacktraceService stacktraceService;

    @Override
    public String removeProperty(String inputJson, String property) {
        try {
            JsonNode rootNode = objectMapper.readTree(inputJson);
            removePropertyRecursive(rootNode, property);
            return objectMapper.writeValueAsString(rootNode);
        } catch (Exception e) {
            log.debug("Can not remove property from json: {}", stacktraceService.convertToSingleLine(e));
            throw new HpException(HpException.Code.HP0004, property, e.getMessage());
        }
    }

    private void removePropertyRecursive(JsonNode node, String propertyToRemove) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            if (objectNode.has(propertyToRemove)) {
                objectNode.remove(propertyToRemove);
            }
            objectNode.fieldNames().forEachRemaining(field ->
                    removePropertyRecursive(node.get(field), propertyToRemove));
        } else if (node.isArray()) {
            for (JsonNode arrayElement : node) {
                removePropertyRecursive(arrayElement, propertyToRemove);
            }
        }
    }
}
