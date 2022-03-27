package me.junjiehuang1020.homework.week.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapacityToShipPackagesWithinDDaysTest {
    
    @Test
    void shipWithinDays() {
    
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
    
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        capacityToShipPackagesWithinDDays.shipWithinDays(weights, days);
    }
}
