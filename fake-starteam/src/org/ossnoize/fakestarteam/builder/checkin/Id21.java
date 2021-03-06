/*
 * All public interface based on Starteam API are a property of Borland, 
 * those interface are reproduced here only for testing purpose. You should
 * never use those interface to create a competitive product to the Starteam
 * Server. 
 * 
 * The implementation is given AS-IS and should not be considered a reference 
 * to the API. The behavior on a lots of method and class will not be the
 * same as the real API. The reproduction only seek to mimic some basic 
 * operation. You will not found anything here that can be deduced by using
 * the real API.
 * 
 * Fake-Starteam is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */
package org.ossnoize.fakestarteam.builder.checkin;

import com.starbase.starteam.File;
import com.starbase.starteam.Folder;
import com.starbase.starteam.View;
import com.starbase.util.OLEDate;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import org.ossnoize.fakestarteam.builder.CheckInInstruction;

/**
 *
 * @author steve
 */
public class Id21 extends CheckInInstruction {

  @Override
  public void checkin(View view) throws IOException {
    Folder root = view.getRootFolder();
    Folder src = findFolderIn(root, "src");

    File blob = findFileIn(src, "blob.java");
    URL blobVer = new URL("https://raw.githubusercontent.com/planestraveler/git-starteam/c0d5d26a24f8592421c043523bdd411fb1055e76/syncronizer/src/org/ossnoize/git/fastimport/Blob.java");
    blob.checkinFromStream(blobVer.openStream(), "Correction for better ease of use", 0, false);

    File data = findFileIn(src, "data.java");
    data.remove();

    view.createViewLabel("Check-in Id 21", "Check Id 21 description", new OLEDate(getTimeOfCheckIn() + 1000), true, true);
  }

  @Override
  public long getTimeOfCheckIn() {
    Calendar time = Calendar.getInstance();
    time.set(2015, 3, 6, 15, 35);
    return time.getTimeInMillis();
  }
  
}
