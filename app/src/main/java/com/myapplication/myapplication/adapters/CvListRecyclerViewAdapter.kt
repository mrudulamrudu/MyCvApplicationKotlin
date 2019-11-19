package com.myapplication.myapplication.adapters

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.BulletSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.myapplication.R
import com.myapplication.myapplication.models.Company
import com.myapplication.myapplication.models.Cv
import java.lang.ref.WeakReference
import java.util.ArrayList

class CvListRecyclerViewAdapter(context: WeakReference<Context>, private var cvArrayList: ArrayList<Cv>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater: LayoutInflater

    init {
        inflater = context.get()?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflater.inflate(R.layout.layout_cvlist_child_row, null)
        return CvListHeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cv = cvArrayList.get(position)
        // Bind Header Data
        val cvListHeaderViewHolder = holder as CvListHeaderViewHolder
        val txtName = cvListHeaderViewHolder.getTxtName()
        val txtPhone = cvListHeaderViewHolder.getTxtPhone()
        val txtEmail = cvListHeaderViewHolder.getTxtEmail()
        val txtLinkedIn = cvListHeaderViewHolder.getTxtLinkedIn()

        txtName?.text = cv.name
        txtPhone?.text = cv.phone
        txtEmail?.text = cv.email
        txtLinkedIn?.text = cv.linkedIn

        // Bind Professional Summary
        val txtPsHeader = cvListHeaderViewHolder.getTxtPsHeader()
        val txtPsummary = cvListHeaderViewHolder.getTxtPSummary()
        val summary = getSpannableString(cv.profSummary)
        txtPsHeader?.visibility = if (TextUtils.isEmpty(summary)) View.GONE else View.VISIBLE
        txtPsummary?.text = summary
        txtPsummary?.visibility = if (TextUtils.isEmpty(summary)) View.GONE else View.VISIBLE

        // Bind Technical Skills
        val txtTsHeader = cvListHeaderViewHolder.getTxtTsHeader()
        val txtTechnicalSkills = cvListHeaderViewHolder.getTxtTechnicalSkills()
        val tSummary = getSpannableString(cv.techSkills)
        txtTsHeader?.visibility = if (TextUtils.isEmpty(tSummary)) View.GONE else View.VISIBLE
        txtTechnicalSkills?.text = getSpannableString(cv.techSkills)
        txtTechnicalSkills?.visibility = if (TextUtils.isEmpty(tSummary)) View.GONE else View.VISIBLE

        // Bind Companies List
        renderCompaniesList(cvListHeaderViewHolder.getLayoutWeSummary(), cv.companies)

    }

    fun setCvArrayList(cvArrayList: ArrayList<Cv>) {
        this.cvArrayList = cvArrayList
    }

    /**
     * Method to bind companies List.
     * Iterate through the companies list and add each child to the parent view
     *
     * @param parent    Linearlayout
     * @param companies list of companies
     */
    private fun renderCompaniesList(parent: LinearLayout?, companies: ArrayList<Company>?) {
        if (parent == null || companies == null || companies.isEmpty()) return
        for (company in companies) {
            val child = inflater.inflate(R.layout.layout_child_company_row, parent, false)
            val txtPosition = child.findViewById<TextView>(R.id.txtPosition)
            val txtCName = child.findViewById<TextView>(R.id.txtCompanyName)
            val txtLocation = child.findViewById<TextView>(R.id.txtCompanyLocation)
            val txtTenure = child.findViewById<TextView>(R.id.txtTenure)
            val txtWSummary = child.findViewById<TextView>(R.id.txtWeSummary)

            txtPosition.text = company.role
            txtCName.text = company.companyName
            txtLocation.text = company.location
            txtTenure.text = company.tenure
            txtWSummary.text = getSpannableString(company.responsibilities)

            parent.addView(child)
        }
    }

    /**
     * Convert arraylist into bullet spannable strting
     *
     * @param pSummary professional summary
     * @return spannable string with bullets
     */
    private fun getSpannableString(pSummary: ArrayList<String>?): String {
        if (pSummary == null || pSummary.isEmpty()) return ""
        val builder = SpannableStringBuilder()
        var startIndex: Int
        var endIndex: Int
        for (i in pSummary.indices) {
            startIndex = builder.length
            builder.append(pSummary[i])
            builder.append("\n")
            endIndex = builder.length
            builder.setSpan(
                BulletSpan(40, Color.BLACK), startIndex, endIndex,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return builder.toString()
    }

    override fun getItemCount(): Int {
        return cvArrayList.size
    }

    private class CvListHeaderViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Header
        private var txtName: TextView? = null
        private var txtEmail: TextView? = null
        private var txtPhone: TextView? = null
        private var txtLinkedIn: TextView? = null

        // PS
        private var txtPsHeader: TextView? = null
        private var txtPSummary: TextView? = null

        // TS
        private var txtTsHeader: TextView? = null
        private var txtTechnicalSkills: TextView? = null

        //We
        private var layoutWeSummary: LinearLayout? = null

        fun getTxtName(): TextView? {
            if (txtName == null) {
                txtName = itemView.findViewById(R.id.txtName)
            }
            return txtName
        }

        fun getTxtEmail(): TextView? {
            if (txtEmail == null) {
                txtEmail = itemView.findViewById(R.id.txtEmail)
            }
            return txtEmail
        }

        fun getTxtPhone(): TextView? {
            if (txtPhone == null) {
                txtPhone = itemView.findViewById(R.id.txtPhone)
            }
            return txtPhone
        }

        fun getTxtLinkedIn(): TextView? {
            if (txtLinkedIn == null) {
                txtLinkedIn = itemView.findViewById(R.id.txtLinkedIn)
            }
            return txtLinkedIn
        }

        fun getTxtPSummary(): TextView? {
            if (txtPSummary == null) {
                txtPSummary = itemView.findViewById(R.id.txtPsSummary)
            }
            return txtPSummary
        }

        fun getLayoutWeSummary(): LinearLayout? {
            if (layoutWeSummary == null) {
                layoutWeSummary = itemView.findViewById(R.id.layoutWeSummary)
            }
            return layoutWeSummary
        }

        fun getTxtTechnicalSkills(): TextView? {
            if (txtTechnicalSkills == null) {
                txtTechnicalSkills = itemView.findViewById(R.id.txtTechnicalSkills)
            }
            return txtTechnicalSkills
        }

        fun getTxtPsHeader(): TextView? {
            if (txtPsHeader == null) {
                txtPsHeader = itemView.findViewById(R.id.txtPsHeader)
            }
            return txtPsHeader
        }

        fun getTxtTsHeader(): TextView? {
            if (txtTsHeader == null) {
                txtTsHeader = itemView.findViewById(R.id.txtTsHeader)
            }
            return txtTsHeader
        }
    }
}