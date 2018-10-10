<%--
  Created by IntelliJ IDEA.
  User: Akvasoft
  Date: 04/09/2018
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="sidebar sidebar-main">
    <div class="sidebar-content">

        <!-- Main navigation -->
        <div class="sidebar-category sidebar-category-visible">
            <div class="category-content no-padding">
                <ul class="navigation navigation-main navigation-accordion">

                    <!-- Main -->
                    <li class="navigation-header"><span style="font-weight: bold; color: white">Main</span> <i
                            class="icon-menu" title="Main pages"></i>
                    </li>
                    <li class="active"><a href="/admin_dash"><i class="icon-home4"></i>
                        <span>Dashboard</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="icon-user"></i> <span>Borrowers</span></a>
                        <ul>
                            <li><a href="/view_borrowers">View Borrowers</a></li>
                            <li><a href="/add_borrowers">Add Borrower</a></li>
                            <li><a href="/borrower_group">View Borrower Group</a></li>
                            <li><a href="/group_registration">Add Borrower Group</a></li>
                            <li><a href="/error/offline">Send SMS to All Borrowers</a></li>
                            <li><a href="/error/offline">Send Email to All Borrowers</a></li>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="icon-balance"></i> <span>Loans</span></a>
                        <ul>
                            <li><a href="/view_loans">View All Loans</a></li>
                            <li><a href="/add_loan">Add Loan</a></li>
                            <li><a href="/view_loan_history">View Loan History</a></li>
                            <li><a href="/approve_loans">Pending Loans</a></li>
                            <%--<li><a href="/error/offline">Loans in Arrears</a></li>--%>
                            <%--<li><a href="/error/offline">No Repayments</a></li>--%>
                            <%--<li><a href="/error/offline">Past Maturity Date</a></li>--%>
                            <%--<li><a href="/error/offline">Principle Outstanding</a></li>--%>
                            <%--<li><a href="/error/offline">1 Month Late Loans</a></li>--%>
                            <%--<li><a href="/error/offline">3 Month Late Loans</a></li>--%>
                            <%--<li><a href="/error/offline">Loan Calculator</a></li>--%>
                            <%--<li><a href="/error/offline">Guarantors</a></li>--%>
                            <%--<li><a href="/error/offline">Loan Comments</a></li>--%>
                            <%--<li class="disabled"><a href="/error/offline">Something--%>
                            <%--New<span class="label label-transparent">Coming soon</span></a></li>--%>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class=" icon-cash"></i> <span>Repayments</span></a>
                        <ul>
                            <li><a href="/error/offline">View Repayments</a></li>
                            <li><a href="/error/offline">Approve Repayments</a></li>
                            <%--<li><a href="/error/offline">Add Bulk Repayments</a></li>--%>
                            <%--<li><a href="/error/offline">Upload Repayments - CSV file</a></li>--%>
                            <%--<li><a href="/error/offline">Repayments Charts</a></li>--%>
                            <%----%>
                            <%--<li class="navigation-divider"></li>--%>
                        </ul>
                    </li>
                    <%--<li><a href="/admin_dash"><i class="icon-list"></i>--%>
                    <%--<span>Collateral Register</span></a>--%>
                    <%--</li>--%>
                    <li><a href="/admin_dash"><i class="icon-calendar"></i>
                        <span>Calendar</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="icon-stack"></i> <span>Collection Sheets</span></a>
                        <%--<ul>--%>
                        <%--<li><a href="/error/offline">Daily Collection Sheet</a></li>--%>
                        <%--<li><a href="/error/offline">Missed Repayment Sheet</a></li>--%>
                        <%--<li><a href="/error/offline">Past Maturity Date Loans</a></li>--%>
                        <%--<li><a href="/error/offline">Send SMS</a></li>--%>
                        <%--<li><a href="/error/offline">Send Email</a></li>--%>
                        <%--</ul>--%>
                    </li>
                    <%--<li>--%>
                    <%--<a href="#"><i class="icon-library2"></i> <span>Savings</span></a>--%>
                    <%--<ul>--%>
                    <%--<li><a href="/error/offline">View Savings Accounts</a></li>--%>
                    <%--<li><a href="/error/offline">Add Saving Account</a></li>--%>
                    <%--<li><a href="/error/offline">Saving Charts</a></li>--%>
                    <%--<li><a href="/error/offline">Saving Report</a></li>--%>
                    <%--<li><a href="/error/offline">Saving Product Report</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="icon-link2"></i> <span>Savings Transactions</span></a>--%>
                    <%--<ul>--%>
                    <%--<li><a href="/error/offline">View Saving Transactions</a></li>--%>
                    <%--<li><a href="/error/offline">Add Bulk Transactions</a></li>--%>
                    <%--<li><a href="/error/offline">Upload Transactions - CSV file</a></li>--%>
                    <%--<li><a href="/error/offline">Staff Transaction Report</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="icon-coin-dollar"></i> <span>Payroll</span></a>--%>
                    <%--<ul>--%>
                    <%--<li><a href="/error/offline">View Payroll</a></li>--%>
                    <%--<li><a href="/error/offline">Add Payroll</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="icon-redo2"></i> <span>Expenses</span></a>--%>
                    <%--<ul>--%>
                    <%--<li><a href="/error/offline">View Expenses</a></li>--%>
                    <%--<li><a href="/error/offline">Add Expenses</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class="icon-plus-circle2"></i> <span>Other Income</span></a>--%>
                    <%--<ul>--%>
                    <%--<li><a href="/error/offline">View Incomes</a></li>--%>
                    <%--<li><a href="/error/offline">Add Income</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#"><i class=" icon-briefcase3"></i> <span>Asset Management</span></a>--%>
                    <%--<ul>--%>
                    <%--<li><a href="/error/offline">View Asset Management</a></li>--%>
                    <%--<li><a href="/error/offline">Add Asset Management</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <li>
                        <a href="#"><i class=" icon-stats-growth"></i> <span>Report</span></a>
                        <ul>
                            <li><a href="/error/offline">Borrowers Report</a></li>
                            <li><a href="/error/offline">Loan Report</a></li>
                            <li><a href="/error/offline">Collections Report</a></li>
                            <li><a href="/error/offline">Collector Report (Staff)</a></li>
                            <li><a href="/error/offline">Deferred Income</a></li>
                            <li><a href="/error/offline">Disbursement Report</a></li>
                            <li><a href="/error/offline">Fees Report</a></li>
                            <li><a href="/error/offline">Loan Officer Report</a></li>
                            <li><a href="/error/offline">Loan Products Report</a></li>
                            <li><a href="/error/offline">MFRS Ratios</a></li>
                            <li><a href="/error/offline">Monthly Report</a></li>
                            <li><a href="/error/offline">Portfolio At Risk (PAR)</a></li>
                            <li><a href="/error/offline">At a Glance Report</a></li>
                            <li><a href="/error/offline">All Entries</a></li>

                        </ul>
                    </li>
                    <%--<li>--%>
                    <%--<a href="#"><i class="icon-book3"></i> <span>Accounting</span></a>--%>
                    <%--<ul>--%>
                    <%--<li><a href="/error/offline">Cash flow Accumulated</a></li>--%>
                    <%--<li><a href="/error/offline">Cash Flow Monthly</a></li>--%>
                    <%--<li><a href="/error/offline">Cash Flow Projection</a></li>--%>
                    <%--<li><a href="/error/offline">Profit/Loss</a></li>--%>
                    <%--<li><a href="/error/offline">Balance Sheet</a></li>--%>
                    <%--<li><a href="/error/offline">Accounting Integration</a></li>--%>
                    <%--<li><a href="/error/offline">Fees Report</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>

                    <li>
                        <a href="#"><i class="icon-cog5"></i> <span>Settings</span></a>
                        <ul>
                            <li><a href="/settings/loans">Loans</a></li>
                            <%--<li><a href="/error/offline">Cash Flow Monthly</a></li>--%>
                            <%--<li><a href="/error/offline">Cash Flow Projection</a></li>--%>
                            <%--<li><a href="/error/offline">Profit/Loss</a></li>--%>
                            <%--<li><a href="/error/offline">Balance Sheet</a></li>--%>
                            <%--<li><a href="/error/offline">Accounting Integration</a></li>--%>
                            <%--<li><a href="/error/offline">Fees Report</a></li>--%>
                        </ul>
                    </li>

                    <%--<!-- /main -->--%>
                </ul>
            </div>
        </div>
        <!-- /main navigation -->
    </div>
</div>
<script type="text/javascript">
    var name = $.session.get("Logged_User");
    if (name === "undefined") {
        window.location.replace("/");
    }
    document.getElementById("user").textContent = name;
</script>
</html>
