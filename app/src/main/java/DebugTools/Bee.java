package debugTools;

import android.util.Log;

import com.orhanobut.bee.BeeConfig;
import com.orhanobut.bee.widgets.Button;
import com.orhanobut.bee.widgets.CheckBox;
import com.orhanobut.bee.widgets.Spinner;
import com.orhanobut.bee.widgets.Title;

import java.util.Map;

/**
 * Created by AhmedIBRAHIM on 11/04/15.
 */
public class Bee extends BeeConfig {

    private String TAG = "Bee";

    /**
     * Add extra information by using content object.
     */
    @Override
    public void onInfoContentCreated(Map<String, String> content) {
        content.put("Current End Point", "http://www.google.com");
    }

    /**
     * Add information to the clipboard by using content object.
     */
    @Override
    public void onClipboardContentCreated(Map<String, String> content) {
        content.put("User1", "324234234");
        content.put("Visa Expire Date", "2/16");
        content.put("Visa Code", "34");
    }

    /**
     * It is called when the save button is pressed
     */
    @Override
    public void onSave() {
        super.onSave();
    }

    /**
     * It is called when the close button is pressed
     */
    @Override
    public void onClose() {
        super.onClose();
        Log.d(TAG, "onClose");
    }

    /**
     * A sample button implementation
     */
    @Title("Reset")
    @Button
    public void onResetClicked() {
        Log.d(TAG, "onResetClicked");
    }

    /**
     * A sample checkbox implementation
     */
    @Title("Show splash screen")
    @CheckBox
    public void onShowSplashChecked(boolean isChecked) {
        Log.d(TAG, "onShowSplashChecked");
    }

    /**
     * A sample spinner implementation
     */
    @Title("End Point")
    @Spinner({"Staging", "Live", "Mock"})
    public void onEndPointSelected(String selectedValue) {
        Log.d(TAG, "onEndPointSelected");
    }

}
