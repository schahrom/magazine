package mapper;

import DTO.UserCreateDTO;
import DTO.UserDTO;
import DTO.UserUpdateDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.MappingTarget;


@Mapper
    public abstract class UserMapper{
        public abstract User map(UserCreateDTO dto);
        public abstract UserDTO map(User user);
        public abstract void update(UserUpdateDTO dto, @MappingTarget User model);

}
