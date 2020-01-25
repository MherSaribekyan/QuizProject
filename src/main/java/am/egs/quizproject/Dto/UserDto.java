package am.egs.quizproject.Dto;


import am.egs.quizproject.model.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {


    private int id;
    private String name;
    private String surname;
    private UserType userType;
    private String email;

}
