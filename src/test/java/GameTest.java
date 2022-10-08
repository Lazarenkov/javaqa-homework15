import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Game;
import ru.netology.javaqa.NotFoundException;
import ru.netology.javaqa.Player;

public class GameTest {

    Game game = new Game();
    Player player1 = new Player(1, "Дарт Вейдер", 500);
    Player player2 = new Player(2, "Люк Скайуокер", 501);
    Player player3 = new Player(3, "Йода", 500);
    Player player4 = new Player(4, "Оби-Ван-Кеноби", 400);
    Player player5 = new Player(5, "Чубака", 10);

    @Test
    public void shouldReturnExceptionWhenCollectionIsEmpty() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Дарт Вейдер", "Йода");
        });
    }

    @Test
    public void shouldReturnExceptionWhenCollectionWithOnePlayer() {
        game.register(player1);
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Дарт Вейдер", "Йода");
        });
    }

    @Test
    public void shouldReturn1IfWinFirstAndCollectionWith2Players() {
        game.register(player1);
        game.register(player2);
        byte expected = 1;
        byte actual = game.round("Люк Скайуокер", "Дарт Вейдер");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn2IfWinSecondAndCollectionWith2Players() {
        game.register(player2);
        game.register(player3);
        byte expected = 2;
        byte actual = game.round("Йода", "Люк Скайуокер");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0IfDrawAndCollectionWith2Players() {
        game.register(player1);
        game.register(player3);
        byte expected = 0;
        byte actual = game.round("Дарт Вейдер", "Йода");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExceptionWhenInvalidFirstNameAndCollectionWith2Players() {
        game.register(player1);
        game.register(player3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Дарт Вейдер", "Оби-Ван-Кеноби");
        });
    }

    @Test
    public void shouldReturnExceptionWhenInvalidSecondNameAndCollectionWith2Players() {
        game.register(player1);
        game.register(player3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Оби-Ван-Кеноби", "Дарт Вейдер");
        });
    }

    @Test
    public void shouldReturnExceptionWhenInvalidBothNamesAndCollectionWith2Players() {
        game.register(player1);
        game.register(player3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Абракадбра1", "Абракадбра2");
        });
    }

    @Test
    public void shouldReturn1IfWinFirstAndCollectionWithPlentyOFPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        byte expected = 1;
        byte actual = game.round("Люк Скайуокер", "Чубака");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn2IfWinSecondAndCollectionWithPlentyOFPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        byte expected = 2;
        byte actual = game.round("Чубака", "Люк Скайуокер");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0IfDrawAndCollectionWithPlentyOFPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        byte expected = 0;
        byte actual = game.round("Дарт Вейдер", "Йода");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExceptionWhenInvalidFirstNameAndCollectionWithPlentyOFPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Абракадабра1", "Оби-Ван-Кеноби");
        });
    }

    @Test
    public void shouldReturnExceptionWhenInvalidSecondNameAndCollectionWithPlentyOFPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Оби-Ван-Кеноби", "Абракадбра2");
        });
    }

    @Test
    public void shouldReturnExceptionWhenInvalidBothNamesAndCollectionWithPlentyOFPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Абракадбра1", "Абракадбра2");
        });
    }
}
