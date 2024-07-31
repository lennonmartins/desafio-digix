package desafioTec.digix.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.valor.Cpf;

@Mapper
public interface IFamiliaMapper {
    IFamiliaMapper INSTANCE = Mappers.getMapper(IFamiliaMapper.class);

    @Mapping(source = "representante.cpf", target = "representante.cpf", qualifiedByName = "cpfToString")
    FamiliaResponseDto toDto(Familia model);

    @Named("cpfToString")
    default String cpfToString(Cpf cpf) {
        return cpf.getValorCpf();
    }

    // @Mapping(source = "representante.cpf", target = "representante.cpf", qualifiedByName = "stringToCpf")
    // Familia toModel(FamiliaRequestDto dto);

    // @Named("stringToCpf")
    // default Cpf stringToCpf(String cpf) {
    //     return new Cpf(cpf);
    // }
}
