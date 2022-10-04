package com.interview.caching.view.dto.mappers;

import com.interview.caching.model.Street;
import com.interview.caching.view.dto.StreetDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StreetMapper extends BaseMapper<StreetDto, Street>{
}
