package com.mclebtec.ideaplugindevelopmentlearning.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.Messages

/**
 * @author: Brian
 */
class HelloActions : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        println("Inside the action method for performing a part....")
        //showFileDialog(e)
        //getUserName(e)
        if (DataDialogWrapper().showAndGet()) {
            //user had pressed ok
            println("Successfully pressed ok")
        }
    }

    private fun getUserName(e: AnActionEvent) {
        val name = Messages.showInputDialog(e.project, "Enter your name", "Idea Demo Data",
                Messages.getQuestionIcon())
        Messages.showMessageDialog(e.project, "Your name is $name", "Idea Demo",
                Messages.getInformationIcon())
    }

    private fun showFileDialog(e: AnActionEvent) {
        val fileChooserDescriptor = FileChooserDescriptor(false,
                true,
                false,
                false,
                false,
                false)
        fileChooserDescriptor.title = "My Idea Demo Learning Pick Directory"
        fileChooserDescriptor.description = "My file chooser demo"
        FileChooser.chooseFile(fileChooserDescriptor, e.project, null) {
            Messages.showMessageDialog(e.project, it.path, "Path", Messages.getInformationIcon())
        }
    }
}
