/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.workstation.system.recipe;

import org.terasology.entitySystem.entity.EntityRef;

import java.util.List;

/**
 * @author Marcin Sciesinski <marcins78@gmail.com>
 */
public interface CraftingStationRecipe {
    /**
     * Inquires if the specified item is a component for that recipe.
     *
     * @param itemEntity
     * @return
     */
    public boolean hasAsComponent(EntityRef itemEntity);

    /**
     * Inquires if the specified item is a tool used in that recipe.
     *
     * @param itemEntity
     * @return
     */
    public boolean hasAsTool(EntityRef itemEntity);

    /**
     * Returns all possible recipes (components->result) that can be done processed using this recipe
     * from the components and tools available in the station entity's inventory.
     *
     * @param stationEntity
     * @param componentFromSlot
     * @param componentSlotCount
     * @param toolFromSlot
     * @param toolSlotCount
     * @return
     */
    public List<CraftingStationResult> getMatchingRecipeResults(EntityRef stationEntity,
                                                                int componentFromSlot, int componentSlotCount,
                                                                int toolFromSlot, int toolSlotCount);

    public CraftingStationResult getResultById(String resultId);

    public interface CraftingStationResult extends CraftProcessDisplay {
        public String getResultId();

        /**
         * Processes the crafting of the recipe once. Returns the entity that should be put (or added to) the result slot.
         *
         * @param stationEntity
         * @param componentFromSlot
         * @param componentSlotCount
         * @param toolFromSlot
         * @param toolSlotCount
         * @return
         */
        public EntityRef craftOne(EntityRef stationEntity, int componentFromSlot, int componentSlotCount,
                                  int toolFromSlot, int toolSlotCount);

        /**
         * Processes the crafting of the recipe maximum possible times. Returns the entity that should be put (or added to)
         * the result slot.
         *
         * @param stationEntity
         * @param componentFromSlot
         * @param componentSlotCount
         * @param toolFromSlot
         * @param toolSlotCount
         * @param resultSlot
         * @return
         */
        public EntityRef craftMax(EntityRef stationEntity, int componentFromSlot, int componentSlotCount,
                                  int toolFromSlot, int toolSlotCount, int resultSlot);
    }
}