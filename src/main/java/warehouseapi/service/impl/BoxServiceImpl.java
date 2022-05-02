package warehouseapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouseapi.dto.BoxDto;
import warehouseapi.mapper.BoxMapper;
import warehouseapi.model.Box;
import warehouseapi.repo.BoxRepo;
import warehouseapi.service.BoxService;

@Service
public class BoxServiceImpl implements BoxService {

        private final BoxRepo boxRepo;
        private final BoxMapper boxMapper;

        @Autowired
        public BoxServiceImpl(BoxRepo boxRepo, BoxMapper boxMapper) {
                this.boxRepo = boxRepo;
                this.boxMapper = boxMapper;
        }

        public BoxDto createWarehouseBoxes(Box box){
                return boxMapper.mapBoxToBoxDto(boxRepo.save(box));
        }

    }