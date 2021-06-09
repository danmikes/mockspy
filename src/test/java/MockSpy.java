import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockSpy {

  @Mock
  private List<String> mockList;

  @Spy
  private List<String> spyList = new ArrayList<String>();

  @Test
  public void testMockList() {
    // mock does nothing
    mockList.add("test");

    assertNull(mockList.get(0));
  }

  @Test
  public void testSpyList() {
    // spy calls real object
    spyList.add("test");

    assertEquals("test", spyList.get(0));
  }

  @Test
  public void testMockWithStub() {
    String expected = "Mock 100";
    // stub makes fake method
    when(mockList.get(100)).thenReturn(expected);

    assertEquals(expected, mockList.get(100));
  }

  @Test
  public void testSpyWithStub() {
    String expected = "Spy 100";
    // Stub replaces real method
    doReturn(expected).when(spyList).get(100);

    assertEquals(expected, spyList.get(100));
  }
}
