package desafioTec.digix.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import desafioTec.digix.dto.ConjugeDto;
import desafioTec.digix.dto.FamiliaRequestDto;
import desafioTec.digix.dto.FamiliaResponseDto;
import desafioTec.digix.dto.RepresentanteDto;
import desafioTec.digix.model.Conjuge;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.Representante;
import desafioTec.digix.model.valor.Cpf;

@Mapper
public interface IFamiliaMapper {
    IFamiliaMapper INSTANCE = Mappers.getMapper(IFamiliaMapper.class);

    @Mapping(source = "representante.cpf", target = "representante.cpf", qualifiedByName = "cpfToString")
    @Mapping(source = "conjuge.cpf", target = "conjuge.cpf", qualifiedByName = "cpfToString")
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

    @Mapping(target = "dataDeNascimento", source = "dataDeNascimento")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "cpf", source = "cpf")
    Conjuge toModel(ConjugeDto dto);
    
}