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
package org.terasology.was.generator.plains.tree;

import org.terasology.anotherWorld.coreBiome.PlainsBiome;
import org.terasology.anotherWorld.decorator.BlockCollectionPredicate;
import org.terasology.gf.PlantType;
import org.terasology.gf.generator.BlockFloraSpawnDefinition;
import org.terasology.plantPack.tree.OakGrowthDefinition;
import org.terasology.was.generator.Blocks;
import org.terasology.world.generator.plugin.RegisterPlugin;

import java.util.Arrays;

@RegisterPlugin
public class OakPlainsSpawnDefinition extends BlockFloraSpawnDefinition {
    public OakPlainsSpawnDefinition() {
        super(PlantType.TREE, OakGrowthDefinition.ID, PlainsBiome.ID, 0.6f, 0.2f,
                new BlockCollectionPredicate(Arrays.asList(Blocks.getBlock("Core:Grass"))));
    }
}