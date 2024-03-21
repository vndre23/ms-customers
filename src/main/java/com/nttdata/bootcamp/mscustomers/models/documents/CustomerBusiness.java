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
@Document(collection = "customers_business")
public class CustomerBusiness {
    @Id
    private String id;
    
    private String nameBusiness;
    private String numberDocument;
    private String address;
    private String phone;
    private Date createdAt;
}
