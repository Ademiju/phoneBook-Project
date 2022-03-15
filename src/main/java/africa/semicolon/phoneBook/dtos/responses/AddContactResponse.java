package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;

@Data
public class AddContactResponse {
    private String fullName;
    private String phoneNumber;
}
