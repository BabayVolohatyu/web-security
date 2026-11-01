package chnu.edu.websecurity26.repository;

/*
  @author   nzon
  @project   web-security26
  @class  ItemRepository
  @version  1.0.0 
  @since 01/11/2026 - 09.40
*/

import chnu.edu.websecurity26.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
