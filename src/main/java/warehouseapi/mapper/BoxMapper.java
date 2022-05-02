package warehouseapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import warehouseapi.dto.BoxDto;
import warehouseapi.model.Box;

/**
 * Mapper for box entity to boxDto
 */
@Mapper(componentModel = "spring")
public interface BoxMapper {
    @Mappings({
            @Mapping(target="box_id", source = "id")
    })
    BoxDto mapBoxToBoxDto(Box box);
}
