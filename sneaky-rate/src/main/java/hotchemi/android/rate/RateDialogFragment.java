package hotchemi.android.rate;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;

/**
 * @author Shintaro Katafuchi
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class RateDialogFragment extends DialogFragment {

    public RateDialogFragment() {
    }

    public static RateDialogFragment newInstance() {
        final Bundle bundle = new Bundle();
        RateDialogFragment dialogFragment = new RateDialogFragment();
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return DialogManager.create(getActivity());
    }

}