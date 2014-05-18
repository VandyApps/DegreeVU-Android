package edu.vanderbilt.degreevu

import android.app.Fragment
import android.view.View
import android.widget.Button

import edu.vanderbilt.degreevu.service.AppService
import edu.vanderbilt.degreevu.framework.{ActorConversion, FragmentInjection, Helpers}

/**
 * Page where you can gaze on a wombat.
 */
class WombatFragment extends Fragment
                             with FragmentInjection[AppService]
                             with ActorConversion
                             with Helpers.EasyFragment
                             with View.OnClickListener
{
  import WombatFragment._

  private def btnBack = component[Button](R.id.button)

  override def layoutId = R.layout.wombat_layout

  override def onStart() {
    super.onStart()
    btnBack.setOnClickListener(this)
  }

  override def onClick(v: View): Unit = {
    app.eventHub ! DoneWatchingWombat
  }

}

object WombatFragment {

  case object DoneWatchingWombat

}