package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_ZeroTorpedos_ThrowsIllegalArgumentException() {
        // Arrange
        TorpedoStore store = new TorpedoStore(5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
    }

    @Test
    void fire_MoreThanAvailable_ThrowsIllegalArgumentException() {
        // Arrange
        TorpedoStore store = new TorpedoStore(2);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(3);
        });
    }

    @Test
    void getTorpedoCount_ReturnsCorrectCount() {
        // Arrange
        TorpedoStore store = new TorpedoStore(4);

        // Act & Assert
        assertEquals(4, store.getTorpedoCount());
    }
}
