import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class tests {




        //all setters work the same so i only REALLY need one. still. 
        @Test
        void testHousingSetter() {
            services community = new services(true, true, true);

            community.setHousing(false);

            assertFalse(community.getHousing());
        }

        @Test
        void testHousingGap() {

            
            services community = new services(true, true, true);
            gapIdentifier gap = new gapIdentifier(community);

            
            gap.check("I need housing");

            
            assertFalse(community.getHousing());
            assertTrue(community.getFood());
            assertTrue(community.getElectric());
        }


        @Test
        void testListenerNotification() {
            services community = new services(true, true, true);
            surveyInput survey = new surveyInput();
            gapIdentifier gap = new gapIdentifier(community);

            
            survey.addListener(gap);
            survey.addResponse("I need food");

            assertFalse(community.getFood());
            assertTrue(community.getHousing());
        }


        @Test
        void testNoMatchingKeyword() {
            services community = new services(true, true, true);
            gapIdentifier gap = new gapIdentifier(community);

            gap.check("I enjoy living here");

            assertTrue(community.getHousing());
            assertTrue(community.getFood());
            assertTrue(community.getElectric());
        }

        @Test
        void testEmptySurvey() {
            surveyInput survey = new surveyInput();

            assertEquals(0, survey.getResponse().size());
        }


        @Test
        void testFoodGap() {
            services community = new services(true, true, true);
            gapIdentifier gap = new gapIdentifier(community);

            gap.check("I need food");

            assertFalse(community.getFood());
            assertTrue(community.getHousing());
            assertTrue(community.getElectric());

        }

        @Test
        void testConstructorWithFalseValues() {
            services community = new services(false, false, false);

            assertFalse(community.getHousing());
            assertFalse(community.getFood());
            assertFalse(community.getElectric());
        }
        //havent reallly used this yet added for code coverage
        @Test
        void testResourceConstructor() {
            ArrayList<String> resources = new ArrayList<>();
            resources.add("Food Bank");
            resources.add("Housing Shelter");

            communityResources community = new communityResources(resources);

            assertEquals(2, community.resources.size());
            assertTrue(community.resources.contains("Food Bank"));
        }


    @Test
    void testMultipleKeywords() {
        
        services community = new services(true, true, true);
        gapIdentifier gap = new gapIdentifier(community);

        
        gap.check("I need housing, food, and electric assistance");

      
        assertFalse(community.getHousing());
        assertFalse(community.getFood());
        assertFalse(community.getElectric());
    }



}