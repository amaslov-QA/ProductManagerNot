package repository;


import org.junit.jupiter.api.Test;
import domain.Book;
import domain.NotFoundException;
import domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book stalker = new Book();

    @Test
    public void shouldSaveOneItem() {
        repository.save(stalker);

        Product[] expected = new Product[]{stalker};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }



    @Test
    void removeByNotFoundId() {
        Book stalkerOne = new Book(1, "Stalker1", 1360, "Orehov", 125, 2008);
        Book stalkerTwo = new Book(7, "Stalker2", 1569, "Levickiy", 325, 2009);


        repository.save(stalkerOne);
        repository.save(stalkerTwo);




        assertThrows(NotFoundException.class, () -> {repository.removeById(2);});




    }

    @Test
    void removeById() {
        Book stalkerOne = new Book(1, "Stalker1", 1360, "Orehov", 125, 2008);
        Book stalkerTwo = new Book(7, "Stalker2", 1569, "Levickiy", 325, 2009);
        Book stalkerFree = new Book(3, "Stalker3", 830, "Orehov", 235, 2010);

        repository.save(stalkerOne);
        repository.save(stalkerTwo);
        repository.save(stalkerFree);


        repository.removeById(1);

        Product[] expected = new Product[]{stalkerTwo, stalkerFree};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}

