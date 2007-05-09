package csdl.jupiter.event;

import junit.framework.TestCase;
import csdl.jupiter.ReviewPlugin;

/**
 * Provides test cases for <code>CodeReviewModeEvent</code>.
 * @author Takuya Yamashita
 * @version $Id: TestCodeReviewModelEvent.java,v 1.4 2005/03/18 09:30:48 takuyay Exp $
 */
public class CodeReviewModelEventTest extends TestCase {
  /**
   * Initializes plugin for test. 
   */
  protected void setUp() {
    ReviewPlugin plugin = new ReviewPlugin();
  }
  
  /**
   * Tests the <code>getEventType</code> method.
   */
  public void testGetEventType() {
    int mergeType = ReviewIssueModelEvent.MERGE;
    int addType = ReviewIssueModelEvent.ADD;
    int deleteType = ReviewIssueModelEvent.DELETE;    
    
    ReviewIssueModelEvent event = new ReviewIssueModelEvent(null, mergeType | addType);
    int eventType = event.getEventType();
    assertEquals("Checking merge type. ", true, (eventType & mergeType) != 0);
    assertEquals("Checking addType type. ", true, (eventType & addType) != 0);
    assertEquals("Checking deleteType type. ", false, (eventType & deleteType) != 0);    
    assertEquals("Checking mergeType and addType type. ", true, 
                (eventType & (mergeType | addType)) != 0);
  }
}