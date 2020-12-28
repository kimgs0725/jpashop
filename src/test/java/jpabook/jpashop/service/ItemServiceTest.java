package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired private ItemService itemService;

    @Autowired private ItemRepository itemRepository;

    @Test
    public void 아이템등록() {
        // given
        Book book = new Book();
        book.setName("bookA");
        book.setPrice(1000);
        book.setStockQuantity(50);
        book.setAuthor("authorA");
        book.setIsbn("abcd-1234");

        // when
        Long saveItem = itemService.saveItem(book);

        // then
        assertEquals(book, itemRepository.findOne((saveItem)));
    }
}