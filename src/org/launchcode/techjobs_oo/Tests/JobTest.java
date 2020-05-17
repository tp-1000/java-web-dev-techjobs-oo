package org.launchcode.techjobs_oo.Tests;


import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private static Job job1 = new Job(new Name("Product tester"), new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


    @Test
    public void testSettingJobId() {
        //Getting the Job class "static nextId field" is handled by sampling the "current ID"
        int nextId = new Job().getId()+1;

        for (int i = nextId; i < nextId+5; i++) {

            assertEquals(i, new Job().getId());
        }
    }

    @Test
    public void testJobConstructorSetsCorrectly() {

        assertTrue(job1.getName() instanceof Name);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void twoJobObjectsNotEqual() {
        Job job2 = new Job(new Name("Product tester"), new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(job1, job2);
    }

    @Test
    public void spaceBeforeAndAfterJobToString() {
        Job job2 = new Job();

        String strJob= job2.toString();

        assertTrue(strJob.matches("\\n(.+\\n)*"));
    }

    @Test
    public void eachJobGetOwnLineWhenToString() {

        String[] strJob = job1.toString().split("\\n");

        assertTrue(strJob[1].equals("ID: "+job1.getId()));
        assertTrue(strJob[2].equals("Name: "+job1.getName()));
        assertTrue(strJob[3].equals("Employer: "+job1.getEmployer()));
        assertTrue(strJob[4].equals("Location: "+job1.getLocation()));
        assertTrue(strJob[5].equals("Position Type: "+job1.getPositionType()));
        assertTrue(strJob[6].equals("Core Competency: "+job1.getCoreCompetency()));
    }

    @Test
    public void emptyJobFieldValuesAreAssignedNoDataMessage() {
        Job job2 = new Job(new Name("Taco"), new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Job job3 = new Job(new Name(""), new Employer("LunchFood"), new Location(""), new PositionType(""), new CoreCompetency(""));

        String[] strJobA = job2.toString().split("\\n");
        String[] strJobB = job3.toString().split("\\n");

        assertTrue(strJobB[2].equals("Name: Data not available"));
        assertTrue(strJobA[3].equals("Employer: Data not available"));
        assertTrue(strJobA[4].equals("Location: Data not available"));
        assertTrue(strJobA[5].equals("Position Type: Data not available"));
        assertTrue(strJobA[6].equals("Core Competency: Data not available"));
    }

    @Test
    public void aJobReturnsNoDataMessageIfHasNoDataAsLongAsAllAtLeastOneOtherFieldOtherThanIdHasData() {
        Job job2 = new Job();
        Job job3 = new Job();
        job2.setName(new Name("A good job"));
        job3.setLocation(new Location("St.Louis"));

        String[] strJobA = job2.toString().split("\\n");
        String[] strJobB = job3.toString().split("\\n");

        assertTrue(strJobB[2].equals("Name: Data not available"));
        assertTrue(strJobA[3].equals("Employer: Data not available"));
        assertTrue(strJobA[4].equals("Location: Data not available"));
        assertTrue(strJobA[5].equals("Position Type: Data not available"));
        assertTrue(strJobA[6].equals("Core Competency: Data not available"));
    }

    @Test
    public void aJobToStringReportsJobIsNonExistentIfAllFieldsButIdHaveNoData() {
        Job job2 = new Job();

        String strJob = job2.toString();

        assertEquals("\nOOPS! This job does not seem to exist.\n", strJob);
    }
}
