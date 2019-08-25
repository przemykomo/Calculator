package przem.calc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;

import static android.util.TypedValue.COMPLEX_UNIT_PX;

public class FontFitTextView extends AppCompatTextView {

    private Paint mTestPaint;
    private float maxSize;
    private int maxWidth;
    private boolean firstDraw = true;

    public FontFitTextView(Context context) {
        super(context);
        initialise();
    }

    public FontFitTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise();
    }

    private void initialise() {
        mTestPaint = new Paint();
        mTestPaint.set(this.getPaint());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (firstDraw) {
            maxSize = this.getTextSize();
            maxWidth = (int) (this.getWidth() * 0.95F);
            Log.d("przemykbug", "maxWidth: " + maxWidth);
            firstDraw = false;
        }
    }

    private void refitText(String text) {
        float currentSize = this.getTextSize();
        if (maxSize == 0.0) {
            return;
        }
        Log.d("przemykbug", "refitText: currentSize: " + currentSize);
        float nextSize;

        mTestPaint.set(this.getPaint());
        float measuredText = mTestPaint.measureText(text);
        Log.d("przemykbug", "refitText: measuredText: " + measuredText);

        nextSize = currentSize / measuredText * (float) maxWidth;
        Log.d("przemykbug", "refitText: nextSize: " + nextSize);
        Log.d("przemykbug", "refitText: maxSize: " + maxSize);

        if (nextSize < maxSize) {
            this.setTextSize(COMPLEX_UNIT_PX, nextSize);
        } else {
            this.setTextSize(COMPLEX_UNIT_PX, maxSize);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        refitText(text.toString());
    }
}
