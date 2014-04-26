package edu.vanderbilt.degreevu

import android.app.Fragment
import android.view.{LayoutInflater, ViewGroup, View}
import android.os.Bundle

/**
 *
 */
trait FragmentViewUtil {
  self: Fragment =>

  def component[T <: View](id: Int) = this.getView.findViewById(id).asInstanceOf[T]

  def layoutId: Int

  override def onCreateView(inflater:  LayoutInflater,
                            container: ViewGroup,
                            saved:     Bundle): View = {
    inflater.inflate(layoutId, container, false)
  }

}
