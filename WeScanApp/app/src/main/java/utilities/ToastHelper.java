package utilities;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wetickets.wescanapp.R;

import enums.NotificationType;

/**
 * Created by dmeij on 4/21/2017.
 */

public class ToastHelper {
    public static void showToast(Activity context, String message, NotificationType notificationType)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) context.findViewById(R.id.custom_toast_container));

        GradientDrawable drawable = (GradientDrawable) layout.getBackground();
        switch (notificationType) {

            case SUCCESS:
                drawable.setColor(context.getResources().getColor(R.color.colorNotificationSuccess));
                break;
            case ERROR:
                drawable.setColor(context.getResources().getColor(R.color.colorNotificationError));
                break;
            case INFO:
                drawable.setColor(context.getResources().getColor(R.color.colorNotificationInfo));
                break;
            case WARNING:
                drawable.setColor(context.getResources().getColor(R.color.colorNotificationWarning));
                break;
            case STATELESS:
                drawable.setColor(context.getResources().getColor(R.color.colorNotificationStateless));
                break;
        }

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(message);

        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
