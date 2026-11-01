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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document
public class Item extends Auditable {
    @Id
    private String id;
    private String name;
    private String description;

    public Item(String description, String name) {
        this.description = description;
        this.name = name;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Item item)) {
            return false;
        }
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
