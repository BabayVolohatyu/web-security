package chnu.edu.websecurity26.model;

/*
  @author   nzon
  @project   web-security26
  @class  Item
  @version  1.0.0 
  @since 31/10/2026 - 11.20
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Item {
    private String id;
    private String name;
    private String description;

    public Item(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
