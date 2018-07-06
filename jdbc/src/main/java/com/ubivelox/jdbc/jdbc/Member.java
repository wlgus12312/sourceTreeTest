package com.ubivelox.jdbc.jdbc;

public class Member
{

    private String name;
    private String job;
    private String phone;





    public Member()
    {
    }





    public Member(final String name, final String job, final String phone)
    {
        this.name = name;
        this.job = job;
        this.phone = phone;
    }





    public String getName()
    {
        return this.name;
    }





    public void setName(final String name)
    {
        this.name = name;
    }





    public String getJob()
    {
        return this.job;
    }





    public void setJob(final String job)
    {
        this.job = job;
    }





    public String getPhone()
    {
        return this.phone;
    }





    public void setPhone(final String phone)
    {
        this.phone = phone;
    }





    @Override
    public String toString()
    {
        return "Member [name=" + this.name + ", job=" + this.job + ", phone=" + this.phone + "]";
    }





    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.job == null) ? 0 : this.job.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
        return result;
    }





    @Override
    public boolean equals(final Object obj)
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final Member other = (Member) obj;
        if ( this.job == null )
        {
            if ( other.job != null )
            {
                return false;
            }
        }
        else if ( !this.job.equals(other.job) )
        {
            return false;
        }
        if ( this.name == null )
        {
            if ( other.name != null )
            {
                return false;
            }
        }
        else if ( !this.name.equals(other.name) )
        {
            return false;
        }
        if ( this.phone == null )
        {
            if ( other.phone != null )
            {
                return false;
            }
        }
        else if ( !this.phone.equals(other.phone) )
        {
            return false;
        }
        return true;
    }

}
