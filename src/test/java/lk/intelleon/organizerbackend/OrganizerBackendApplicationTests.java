package lk.intelleon.organizerbackend;

import lk.intelleon.organizerbackend.entity.Category;
import lk.intelleon.organizerbackend.entity.Inventory;
import lk.intelleon.organizerbackend.entity.User;
import lk.intelleon.organizerbackend.projection.InventoryProjection;
import lk.intelleon.organizerbackend.repository.CategoryRepo;
import lk.intelleon.organizerbackend.repository.InventoryRepo;
import lk.intelleon.organizerbackend.repository.ItemRepo;
import lk.intelleon.organizerbackend.repository.UserRepository;
import lk.intelleon.organizerbackend.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class OrganizerBackendApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Autowired
	InventoryRepo inventoryRepo;

	@Autowired
	CategoryRepo category;

	@Autowired
	ItemRepo itemRepo;

	@Test
	void contextLoads() {

		/*List<InventoryProjection> pendingToExpireItems = inventoryRepo.getPendingToExpireItems();
		System.out.println(pendingToExpireItems.get(0).getItemName());*/

		System.out.println(inventoryRepo.existsByItem_Id(1L));

	}

	@Autowired
	CategoryService categoryService;

	@Test
	void checkService(){
		System.out.println(categoryService.remove(2L).toString());

	}

}
