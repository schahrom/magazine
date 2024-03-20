package mapper;

import DTO.UserDTO;
import model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper
public abstract class UserMapper {
    public abstract User map(UserDTO dto);

    public abstract UserDTO map(User user);

    public abstract void update(UserDTO dto, @MappingTarget User model);

}
