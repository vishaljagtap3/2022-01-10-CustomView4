package `in`.bitcode.customview4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView

@SuppressLint("AppCompatCustomView")
class GraphView(context: Context, attributeSet: AttributeSet?) : ImageView(context, attributeSet)  {

    constructor(context: Context) : this(context, null)

    var values : Array<Int>? = null
    set(value) {
        field = value
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(values == null) {
            return
        }

        var paint = Paint()
        paint.color = Color.RED

        var barWidth = width.toFloat() / values?.size!!
        var perToHeight = height.toFloat() / 100

        for(i in 0 until values?.size!!) {
            canvas?.drawRect(
                barWidth * i,
                height - (values!![i].toFloat() * perToHeight),
                width + i * width.toFloat(),
                height.toFloat(),
                paint
            )
        }
    }
}