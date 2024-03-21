package com.nttdata.bootcamp.mscustomers.models.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "customers_personal")
public class CustomerPersonal {

    @Id
    private String id;
    private String numberDocument;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private Date createAt;
}
