package africa.semicolon.phoneBook.dtos.requests;

import lombok.Data;

@Data
public class AddContactRequest {
    private String firstName;
    private String middleName;
    private String officeAddress;
    private String lastName;
    private String phoneNumber;
}
