import core.AcronymDetail;
import core.AcronymMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AcronymMapTest {

    @Test
    public void testAddToMap () {
        AcronymMap acronymMap = new AcronymMap();
        assertEquals(0, acronymMap.getMap().size());

        acronymMap.add(new AcronymDetail("bac", "banana apple cutting"));

        assertEquals(1, acronymMap.getMap().size());
        List<String> next1 = new ArrayList<String>();
        next1.addAll(acronymMap.getMap().keySet());
        System.out.println(next1);
        assertEquals(next1.toString(), "abc", next1.get(0));
        AcronymDetail next = acronymMap.getMap().values().iterator().next();
        assertEquals("bac", next.getAcronym());
        assertEquals("banana apple cutting", next.getExpandedAcronym());
    }

    @Test
    public void testGetFromMap () {
        AcronymMap acronymMap = new AcronymMap();
        AcronymDetail originalInput = new AcronymDetail("bac", "banana apple cutting");
        acronymMap.add(originalInput);

        assertNull(acronymMap.getValues("xyz"));
        assertNotNull(acronymMap.getValues("abc"));
        assertNotNull(acronymMap.getValues("bac"));
        assertNotNull(acronymMap.getValues("bca"));
        assertNotNull(acronymMap.getValues("acb"));
        assertNotNull(acronymMap.getValues("cba"));
        assertNotNull(acronymMap.getValues("cab"));

        assertEquals(originalInput, acronymMap.getValues("cab"));
        assertEquals(acronymMap.getValues("cba"), acronymMap.getValues("cab"));
        assertEquals(acronymMap.getValues("bac"), acronymMap.getValues("abc"));
    }
}