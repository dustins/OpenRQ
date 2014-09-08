/*
 * Copyright 2014 Jose Lopes
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright 2011-2014, by Vladimir Kostyukov and Contributors.
 * 
 * This file is part of la4j project (http://la4j.org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Contributor(s): -
 */
package net.fec.openrq.util.linearalgebra.vector.sparse;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import net.fec.openrq.util.linearalgebra.io.ByteVectorIterator;
import net.fec.openrq.util.linearalgebra.vector.AbstractByteVectorTest;

import org.junit.Test;


public abstract class SparseByteVectorTest extends AbstractByteVectorTest {

    @Test
    public void testCardinality() {

        SparseByteVector a = (SparseByteVector)factory().createVector(
            new byte[] {0, 0, 0, 0, 1});

        assertEquals(1, a.cardinality());
    }

    @Test
    public void testNonZeroIterator_1() {

        SparseByteVector a = (SparseByteVector)factory().createVector(new byte[] {0, 1, 0, 2, 3, 0});
        ByteVectorIterator it = a.nonZeroIterator();

        it.next();
        assertEquals(1, it.get());
        assertEquals(1, it.index());

        it.next();
        assertEquals(2, it.get());
        assertEquals(3, it.index());

        it.next();
        assertEquals(3, it.get());
        assertEquals(4, it.index());

        assertFalse(it.hasNext());
    }

    @Test
    public void testNonZeroIterator_2() {

        SparseByteVector a = (SparseByteVector)factory().createVector(new byte[] {1, 2, 3});
        ByteVectorIterator it = a.nonZeroIterator();

        it.next();
        assertEquals(1, it.get());
        assertEquals(0, it.index());

        it.next();
        assertEquals(2, it.get());
        assertEquals(1, it.index());

        it.next();
        assertEquals(3, it.get());
        assertEquals(2, it.index());

        assertFalse(it.hasNext());
    }
}
