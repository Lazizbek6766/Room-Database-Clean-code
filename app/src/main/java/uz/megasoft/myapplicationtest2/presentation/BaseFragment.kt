package uz.megasoft.myapplicationtest2.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment(private val layoutRes: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        return inflater.inflate(layoutRes, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        loadingDialog = ProgressBarDialog(requireContext())
    }

//    protected fun showMessage(message: String) {
//        val dialog = MessageDialog(message)
//        dialog.onClickListener = {
//            dialog.dismiss()
//        }
//        dialog.show(childFragmentManager, "message_dialog")
//    }
//
//    fun showProgress(){
//        loadingDialog.show()
//    }
//
//    fun hideProgress(){
//        loadingDialog.dismiss()
//    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}