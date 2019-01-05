package com.galvanize;

import org.junit.jupiter.api.Test;

public class CellPhoneTest {
    @Test
    public void InstanceDeclaration() {
        CellPhone cellPhone = new CellPhone(new CallingCard(10));
    }
}
