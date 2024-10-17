package com.javaacademy;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedWriter;

/**
 * Фабрика по переработке мусора
 */
@UtilityClass
public class UtilizationFactory {
    public final double BOTTLE_SIZE = 500;

    @SneakyThrows
    private Bottle refactorGlassGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.GLASS) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из стекла!");
        }
        return new Bottle(BOTTLE_SIZE, garbage.getCityFrom());
    }

    @SneakyThrows
    private Cartoon refactorPaperGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.PAPER) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из бумаги!");
        }
        return new Cartoon(garbage.getWeight() / 2);
    }

    @SneakyThrows
    public void refactorGarbage(Garbage[] garbageArray, BufferedWriter journal) {
        for (Garbage garbage : garbageArray) {
            switch (garbage.getGarbageType()) {
                case GLASS -> journal.write(JournalRecord.builder()
                        .bottle(UtilizationFactory.refactorGlassGarbage(garbage))
                        .build()
                        .toString());
                case PAPER -> journal.write(JournalRecord.builder()
                        .cartoon(UtilizationFactory.refactorPaperGarbage(garbage))
                        .build()
                        .toString());
                default -> journal.write(JournalRecord.builder()
                        .garbageWeight(garbage.getWeight())
                        .build()
                        .toString());
            }
        }
    }
}