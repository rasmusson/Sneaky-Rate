package hotchemi.android.rate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

/**
 * @author Shintaro Katafuchi
 */
class DialogManager {

    private DialogManager() {
    }

    /**
     * Create rate dialog.
     *
     * @param context             context
     */
    static Dialog create(final Context context) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.rate_dialog_title);
        builder.setMessage(R.string.rate_dialog_message);
        builder.setNegativeButton(R.string.rate_dialog_rate_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String packageName = context.getPackageName();
                Intent intent = new Intent(Intent.ACTION_VIEW, UriUtils.getGooglePlayUri(packageName));
                context.startActivity(intent);
                //    PreferenceUtils.setAgreeShowDialog(context, false);
            }
        });
            builder.setNeutralButton(R.string.rate_dialog_feedback_button, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.setType("text/email");
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{context.getString(R.string.rate_dialog_feedback_email)});
                    email.putExtra(Intent.EXTRA_SUBJECT, R.string.rate_dialog_feedback_subject);
                    email.putExtra(Intent.EXTRA_TEXT, R.string.rate_dialog_feedback_body);
                    context.startActivity(Intent.createChooser(email, context.getString(R.string.rate_dialog_feedback_dialog_title)));
             //       PreferenceUtils.setAgreeShowDialog(context, false);
                }
            });

        builder.setPositiveButton(R.string.rate_dialog_stop_showing_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //  PreferenceUtils.setAgreeShowDialog(context, false);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                PreferenceUtils.clearSharedPreferences(context);
            }
        });
        return builder.create();
    }

}