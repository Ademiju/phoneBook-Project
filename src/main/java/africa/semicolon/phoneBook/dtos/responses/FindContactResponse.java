package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;

@Data
public class FindContactResponse {
    private String fullName;
    private String phoneNumber;
}
