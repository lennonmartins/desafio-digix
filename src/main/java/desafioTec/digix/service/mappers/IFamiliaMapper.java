package desafioTec.digix.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;
import desafioTec.digix.dtos.RepresentanteDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.Representante;
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
    
    @Mapping(target = "representante.dataDeNascimento", source = "representante.dataDeNascimento")
    @Mapping(target = "representante.nome", source = "representante.nome")
    @Mapping(target = "rendaTotal", source = "rendaTotal")
    Familia toModel(FamiliaRequestDto dto);

    @Mapping(target = "dataDeNascimento", source = "dataDeNascimento")
    @Mapping(target = "nome", source = "nome")
    Representante toModel(RepresentanteDto dto);
}
