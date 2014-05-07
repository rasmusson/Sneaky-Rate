package hotchemi.android.rate;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * @author Shintaro Katafuchi
 */
class RateDialogSupportFragment extends DialogFragment {

    public RateDialogSupportFragment() {
    }

    public static RateDialogSupportFragment newInstance() {
        final Bundle bundle = new Bundle();
        RateDialogSupportFragment dialogFragment = new RateDialogSupportFragment();
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Bundle params = getArguments();
        return DialogManager.create(getActivity());
    }

}