package view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PictureView extends androidx.appcompat.widget.AppCompatImageView {
    public PictureView(Context context){
        this(context,null);
    }
    public PictureView(Context context, AttributeSet attributeSet){
        this(context,attributeSet,0);
    }

    public PictureView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context,attributeSet,defStyleAttr);
    }
}
