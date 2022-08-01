package servicedesk;

import java.util.List;

public class KnowledgeBaseEntity 
{
private Integer Entityid;
private String entityTitle;
private String entityDescription;
private List<String> stepsToResolve;
private List<String> keywords;
private Status status;
private List<Integer> callLinks;

    public KnowledgeBaseEntity(Integer Entityid,
                               String entityTitle,
                               String entityDescription,
                               List<String> stepsToResolve,
                               List<String> keywords,
                               Status status,
                               List<Integer> callLinks) throws NullPointerException
    {
        this.Entityid = Entityid;
        this.entityTitle = entityTitle;
        this.entityDescription = entityDescription;
        if(stepsToResolve.size()<=0)
        {
            throw new NullPointerException("No Steps To resolve");
        }
        this.stepsToResolve = stepsToResolve;
        this.keywords = keywords;
        this.status = status;
        this.callLinks = callLinks;
    }

    public Integer getEntityid() {
        return Entityid;
    }

    public String getEntityTitle() {
        return entityTitle;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public List<String> getStepsToResolve() {
        return stepsToResolve;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public Status getStatus() {
        return status;
    }

    public List<Integer> getCallLinks() {
        return callLinks;
    }

    void addCall(Integer callId) 
    {
        this.callLinks.add(callId);
    }

}
