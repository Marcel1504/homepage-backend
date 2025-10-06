package me.marcelberger.homepage.backend.facade.media;

import jakarta.validation.constraints.NotNull;
import me.marcelberger.homepage.backend.data.media.HpMediaData;

public interface HpMediaFacade {
    HpMediaData getByName(@NotNull String name);
}
