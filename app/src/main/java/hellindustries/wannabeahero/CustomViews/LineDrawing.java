package hellindustries.wannabeahero.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mathieu on 10/3/17.
 */

public class LineDrawing extends View {

    private Point start;
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    private Point point5;
    private Point point6;
    private Point end;

    private Paint mCircle;
    private Paint mLine;


    public LineDrawing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(){
        mCircle = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
        invalidate();
        requestLayout();
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
        invalidate();
        requestLayout();
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
        invalidate();
        requestLayout();
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
        invalidate();
        requestLayout();
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
        invalidate();
        requestLayout();
    }

    public Point getPoint5() {
        return point5;
    }

    public void setPoint5(Point point5) {
        this.point5 = point5;
        invalidate();
        requestLayout();
    }

    public Point getPoint6() {
        return point6;
    }

    public void setPoint6(Point point6) {
        this.point6 = point6;
        invalidate();
        requestLayout();
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
        invalidate();
        requestLayout();
    }
}
