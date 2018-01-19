package doctorsay.izx.com.test.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 严选/探店列表实体类
 * Created by haohaitao on 17/8/14.
 */

public class StrictSelectionBean extends ParentBean implements Serializable {

    private DouDianProject result;

    @Override
    public String toString() {
        return "StrictSelectionBean{" +
                "result=" + result +
                '}';
    }

    public DouDianProject getResult() {
        return result;
    }

    public static class DouDianProject implements Serializable {
        private int code;
        private boolean result;
        private List<PageStarResult> data;

        @Override
        public String toString() {
            return "DouDianProject{" +
                    "code=" + code +
                    ", result=" + result +
                    ", data=" + data +
                    '}';
        }

        public int getCode() {
            return code;
        }

        public boolean isResult() {
            return result;
        }

        public List<PageStarResult> getData() {
            return data;
        }
    }

    /**
     * 已购的数据
     */
    public static class Project_InfoData implements Serializable {
        private String id;
        private long CreateTime;
        private String NameCardUserId;
        private String ProjectName;
        private String ProjectDescription;
        private String ProjectClass;
        private String ProjectType;
        private String PreviewImageUrl;
        private String City;
        private boolean OnlyBuy;
        private int SampleBuyPrice;
        private int WholeCaseBuyPrice;
        private boolean HasContactsBuy;
        private boolean HasSampleBuy;
        private boolean HasWholeCaseBuy;
        private String CompanyLogoUrl;
        private String CompanyName;
        private String CallTimesNum;
        private int SampleBuyTimesNum;
        private int WholeCaseBuyTimesNum;
        private List<String> Tags;
        private ExtendsPrototypesData ExtendsPrototypes;
        private GoodwillData Goodwill;
        private UserImpressionData UserImpression;
        private int RecommandTimesNum;
        private String CreatorId;
        private int OrderNo;
        private int Status;
        private String AppKey;
        private int CommentCount;
        private boolean UserPayPackageUseStatus;
        private NameCardInfoData NameCardInfo;

        public long getCreateTime() {
            return CreateTime;
        }

        public String getId() {
            return id;
        }

        public String getNameCardUserId() {
            return NameCardUserId;
        }

        public String getProjectName() {
            return ProjectName;
        }

        public String getProjectDescription() {
            return ProjectDescription;
        }

        public String getProjectClass() {
            return ProjectClass;
        }

        public String getProjectType() {
            return ProjectType;
        }

        public String getPreviewImageUrl() {
            return PreviewImageUrl;
        }

        public String getCity() {
            return City;
        }

        public boolean isOnlyBuy() {
            return OnlyBuy;
        }

        public int getSampleBuyPrice() {
            return SampleBuyPrice;
        }

        public int getWholeCaseBuyPrice() {
            return WholeCaseBuyPrice;
        }

        public boolean isHasContactsBuy() {
            return HasContactsBuy;
        }

        public boolean isHasSampleBuy() {
            return HasSampleBuy;
        }

        public boolean isHasWholeCaseBuy() {
            return HasWholeCaseBuy;
        }

        public String getCompanyLogoUrl() {
            return CompanyLogoUrl;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public String getCallTimesNum() {
            return CallTimesNum;
        }

        public int getSampleBuyTimesNum() {
            return SampleBuyTimesNum;
        }

        public int getWholeCaseBuyTimesNum() {
            return WholeCaseBuyTimesNum;
        }

        public List<String> getTags() {
            return Tags;
        }

        public ExtendsPrototypesData getExtendsPrototypes() {
            return ExtendsPrototypes;
        }

        public GoodwillData getGoodwill() {
            return Goodwill;
        }

        public UserImpressionData getUserImpression() {
            return UserImpression;
        }

        public int getRecommandTimesNum() {
            return RecommandTimesNum;
        }

        public String getCreatorId() {
            return CreatorId;
        }

        public int getOrderNo() {
            return OrderNo;
        }

        public int getStatus() {
            return Status;
        }

        public String getAppKey() {
            return AppKey;
        }

        public int getCommentCount() {
            return CommentCount;
        }

        public boolean isUserPayPackageUseStatus() {
            return UserPayPackageUseStatus;
        }

        public NameCardInfoData getNameCardInfo() {
            return NameCardInfo;
        }
    }

    /**
     * 详情数据
     */
    public static class PageStarResult implements Serializable {

        private String XiaoYangCount;
        private String id;
        private long CreateTime;
        private boolean IsMyProject;
        private String NameCardUserId;
        private String ProjectName;
        private String ProjectDescription;
        private String ProjectClass;
        private String ProjectType;
        private String PreviewImageUrl;
        private String City;
        private boolean OnlyBuy;
        private int SampleBuyPrice;
        private int WholeCaseBuyPrice;
        private boolean HasContactsBuy;
        private boolean HasSampleBuy;
        private boolean HasWholeCaseBuy;
        private String CompanyLogoUrl;
        private String CompanyName;
        private String CallTimesNum;
        private int SampleBuyTimesNum;
        private int WholeCaseBuyTimesNum;
        private List<String> Tags;
        private ExtendsPrototypesData ExtendsPrototypes;
        private GoodwillData Goodwill;
        private UserImpressionData UserImpression;
        private int RecommandTimesNum;
        private String CreatorId;
        private int OrderNo;
        private int Status;
        private String AppKey;
        private int CommentCount;
        private boolean UserPayPackageUseStatus;
        private Project_InfoData Project_Info;
        private NameCardInfoData NameCardInfo;
        private Company_InfoData Company_Info;

        public long getCreateTime() {
            return CreateTime;
        }

        public boolean getIsMyProject() {
            return IsMyProject;
        }

        public Company_InfoData getCompany_Info() {
            return Company_Info;
        }

        public String getXiaoYangCount() {
            return XiaoYangCount;
        }

        @Override
        public String toString() {
            return "PageStarResult{" +
                    "id='" + id + '\'' +
                    ", NameCardUserId='" + NameCardUserId + '\'' +
                    ", ProjectName='" + ProjectName + '\'' +
                    ", ProjectDescription='" + ProjectDescription + '\'' +
                    ", ProjectClass='" + ProjectClass + '\'' +
                    ", ProjectType='" + ProjectType + '\'' +
                    ", PreviewImageUrl='" + PreviewImageUrl + '\'' +
                    ", City='" + City + '\'' +
                    ", OnlyBuy=" + OnlyBuy +
                    ", SampleBuyPrice=" + SampleBuyPrice +
                    ", WholeCaseBuyPrice=" + WholeCaseBuyPrice +
                    ", HasContactsBuy=" + HasContactsBuy +
                    ", HasSampleBuy=" + HasSampleBuy +
                    ", HasWholeCaseBuy=" + HasWholeCaseBuy +
                    ", CompanyLogoUrl='" + CompanyLogoUrl + '\'' +
                    ", CompanyName='" + CompanyName + '\'' +
                    ", CallTimesNum='" + CallTimesNum + '\'' +
                    ", SampleBuyTimesNum=" + SampleBuyTimesNum +
                    ", WholeCaseBuyTimesNum=" + WholeCaseBuyTimesNum +
                    ", Tags=" + Tags +
                    ", ExtendsPrototypes=" + ExtendsPrototypes +
                    ", Goodwill=" + Goodwill +
                    ", UserImpression=" + UserImpression +
                    ", RecommandTimesNum=" + RecommandTimesNum +
                    ", CreatorId='" + CreatorId + '\'' +
                    ", OrderNo=" + OrderNo +
                    ", Status=" + Status +
                    ", AppKey='" + AppKey + '\'' +
                    ", CommentCount=" + CommentCount +
                    ", NameCardInfo=" + NameCardInfo +
                    '}';
        }

        public Project_InfoData getProject_Info() {
            return Project_Info;
        }

        public boolean isUserPayPackageUseStatus() {
            return UserPayPackageUseStatus;
        }

        public int getSampleBuyPrice() {
            return SampleBuyPrice;
        }

        public int getWholeCaseBuyPrice() {
            return WholeCaseBuyPrice;
        }

        public int getCommentCount() {
            return CommentCount;
        }

        public UserImpressionData getUserImpression() {
            return UserImpression;
        }

        public GoodwillData getGoodwill() {
            return Goodwill;
        }


        public NameCardInfoData getNameCardInfo() {
            return NameCardInfo;
        }

        public ExtendsPrototypesData getExtendsPrototypes() {
            return ExtendsPrototypes;
        }


        public String getNameCardUserId() {
            return NameCardUserId;
        }

        public String getId() {
            return id;
        }

        public String getProjectName() {
            return ProjectName;
        }

        public String getProjectDescription() {
            return ProjectDescription;
        }

        public String getProjectClass() {
            return ProjectClass;
        }

        public String getProjectType() {
            return ProjectType;
        }

        public String getPreviewImageUrl() {
            return PreviewImageUrl;
        }

        public String getCity() {
            return City;
        }

        public boolean isOnlyBuy() {
            return OnlyBuy;
        }

        public boolean isHasContactsBuy() {
            return HasContactsBuy;
        }

        public boolean isHasSampleBuy() {
            return HasSampleBuy;
        }

        public boolean isHasWholeCaseBuy() {
            return HasWholeCaseBuy;
        }

        public String getCompanyLogoUrl() {
            return CompanyLogoUrl;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public String getCallTimesNum() {
            return CallTimesNum;
        }

        public int getSampleBuyTimesNum() {
            return SampleBuyTimesNum;
        }

        public int getWholeCaseBuyTimesNum() {
            return WholeCaseBuyTimesNum;
        }

        public List<String> getTags() {
            return Tags;
        }


        public int getRecommandTimesNum() {
            return RecommandTimesNum;
        }

        public String getCreatorId() {
            return CreatorId;
        }

        public int getOrderNo() {
            return OrderNo;
        }

        public int getStatus() {
            return Status;
        }

        public String getAppKey() {
            return AppKey;
        }
    }

    public static class ExtendsPrototypesData implements Serializable {
        /**
         * 详情里的一些字段
         */
        private String Storefront;
        private String StoresName;
        private String PartyAName;
        private String Address;
        private String State;
        private String City;
        private String Acreage;
        private String AgentShopNumber;
        private String ManyPayNumber;
        private String TelNumber;
        private String PayNumber;
        private String AuthorityName;
        private String AuthorityPosition;
        private String AuthorityHeadImageUrl;
        private String AuthorityComments;
        private String ProjectVideoUrl;
        private int ImagesNumber;

        public String getState() {
            return State;
        }

        public String getCity() {
            return City;
        }

        /**
         * 星探足迹
         */
        private String ZuJiZongShu;
        private String StoreNum;
//
        public String getZuJiZongShu() {
            return ZuJiZongShu;
        }

        public String getStoreNum() {
            return StoreNum;
        }

        /**
         * 诚意金属性
         */
        private String SincerityGold;

        public String getSincerityGold() {
            return SincerityGold;
        }

        public void setTitle_Chengyijin(String title_Chengyijin) {
            Title_Chengyijin = title_Chengyijin;
        }

        public void setDescription_Chengyijin(String description_Chengyijin) {
            Description_Chengyijin = description_Chengyijin;
        }

        /**
         * 诚意金说明属性
         */
        private String Title_Chengyijin;
        private String Description_Chengyijin;

        public String getTitle_Chengyijin() {
            return Title_Chengyijin;
        }

        public String getDescription_Chengyijin() {
            return Description_Chengyijin;
        }

        /**
         * 评论列表的属性
         */
        private String NickName;
        private String Avatar;

        public String getAvatar() {
            return Avatar;
        }

        public String getNickName() {
            return NickName;
        }

        private boolean IsTop;
        private boolean QuanAnBuy;
        private boolean XiaoYangBuy;
        private boolean LianXiRenBuy;

        public boolean isTop() {
            return IsTop;
        }

        /**
         * 个人信息里的一些字段
         */
        private int Score;
        private String Email;
        private String Mobile;
        private String Position;
        private List<String> ChengJiu;
        private List<String> XuQiu;

        public String getMobile() {
            return Mobile;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public void setPosition(String position) {
            Position = position;
        }

        public void setChengJiu(List<String> chengJiu) {
            ChengJiu = chengJiu;
        }

        public void setXuQiu(List<String> xuQiu) {
            XuQiu = xuQiu;
        }

        /**
         * 充值里的一些字段
         */
        private int RechargeType;
        private int ExchangeVirtualCurrency;
        private int ReturnVirtualCurrency;
        private long ActivityStarTime;
        private long ActivityEndTime;

        public int getImagesNumber() {
            return ImagesNumber;
        }

        public long getActivityStarTime() {
            return ActivityStarTime;
        }

        public int getRechargeType() {
            return RechargeType;
        }

        public int getExchangeVirtualCurrency() {
            return ExchangeVirtualCurrency;
        }

        public int getReturnVirtualCurrency() {
            return ReturnVirtualCurrency;
        }

        public long getActivityEndTime() {
            return ActivityEndTime;
        }

        public String getPosition() {
            return Position;
        }

        private int PayPackageType;

        public int getPayPackageType() {
            return PayPackageType;
        }

        public String getStoresName() {
            return StoresName;
        }

        public String getPartyAName() {
            return PartyAName;
        }

        public List<String> getChengJiu() {
            return ChengJiu;
        }

        public List<String> getXuQiu() {
            return XuQiu;
        }



        public boolean isXiaoYangBuy() {
            return XiaoYangBuy;
        }

        public boolean isLianXiRenBuy() {
            return LianXiRenBuy;
        }

        public boolean isQuanAnBuy() {
            return QuanAnBuy;
        }

        public String getEmail() {
            return Email;
        }

        public int getScore() {
            return Score;
        }

        public String getProjectVideoUrl() {
            return ProjectVideoUrl;
        }

        public String getAuthorityName() {
            return AuthorityName;
        }

        public String getAuthorityPosition() {
            return AuthorityPosition;
        }

        public String getAuthorityHeadImageUrl() {
            return AuthorityHeadImageUrl;
        }

        public String getAuthorityComments() {
            return AuthorityComments;
        }

        public String getTelNumber() {
            return TelNumber;
        }

        public String getPayNumber() {
            return PayNumber;
        }

        public String getAgentShopNumber() {
            return AgentShopNumber;
        }

        public String getManyPayNumber() {
            return ManyPayNumber;
        }

        public String getStorefront() {
            return Storefront;
        }

        public String getAddress() {
            return Address;
        }

        public String getAcreage() {
            return Acreage;
        }

        @Override
        public String toString() {
            return "ExtendsPrototypesData{" +
                    "Storefront='" + Storefront + '\'' +
                    ", StoresName='" + StoresName + '\'' +
                    ", PartyAName='" + PartyAName + '\'' +
                    ", Address='" + Address + '\'' +
                    ", Acreage='" + Acreage + '\'' +
                    ", AgentShopNumber='" + AgentShopNumber + '\'' +
                    ", ManyPayNumber='" + ManyPayNumber + '\'' +
                    ", TelNumber='" + TelNumber + '\'' +
                    ", PayNumber='" + PayNumber + '\'' +
                    ", AuthorityName='" + AuthorityName + '\'' +
                    ", AuthorityPosition='" + AuthorityPosition + '\'' +
                    ", AuthorityHeadImageUrl='" + AuthorityHeadImageUrl + '\'' +
                    ", AuthorityComments='" + AuthorityComments + '\'' +
                    ", ProjectVideoUrl='" + ProjectVideoUrl + '\'' +
                    ", ImagesNumber='" + ImagesNumber + '\'' +
                    ", SincerityGold=" + SincerityGold +
                    ", QuanAnBuy=" + QuanAnBuy +
                    ", XiaoYangBuy=" + XiaoYangBuy +
                    ", LianXiRenBuy=" + LianXiRenBuy +
                    ", Score=" + Score +
                    ", Email='" + Email + '\'' +
                    ", Position='" + Position + '\'' +
                    ", ChengJiu=" + ChengJiu +
                    ", XuQiu=" + XuQiu +
                    ", RechargeType=" + RechargeType +
                    ", ExchangeVirtualCurrency=" + ExchangeVirtualCurrency +
                    ", ReturnVirtualCurrency=" + ReturnVirtualCurrency +
                    ", ActivityStarTime=" + ActivityStarTime +
                    ", ActivityEndTime=" + ActivityEndTime +
                    ", PayPackageType=" + PayPackageType +
                    '}';
        }
    }

    /**
     * 信誉级别
     */
    public static class GoodwillData implements Serializable {

        private boolean ZhiZhao;
        private boolean HeTong;
        private boolean FaPiao;
        private boolean JiaFang;
        private int Score;


        @Override
        public String toString() {
            return "GoodwillData{" +
                    "ZhiZhao=" + ZhiZhao +
                    ", HeTong=" + HeTong +
                    ", FaPiao=" + FaPiao +
                    ", JiaFang=" + JiaFang +
                    ", Score=" + Score +
                    '}';
        }

        public int getScore() {
            return Score;
        }

        public boolean isZhiZhao() {
            return ZhiZhao;
        }

        public boolean isHeTong() {
            return HeTong;
        }

        public boolean isFaPiao() {
            return FaPiao;
        }

        public boolean isJiaFang() {
            return JiaFang;
        }
    }

    /**
     * 用户映像
     */
    public static class UserImpressionData implements Serializable {

        private String TelNumber;
        private String PayNumber;
        private String AgentShopNumber;
        private String ManyPayNumber;
        private String AgentShopNumberCount;
        private String ManyPayNumberCount;

        @Override
        public String toString() {
            return "UserImpressionData{" +
                    "TelNumber='" + TelNumber + '\'' +
                    ", PayNumber='" + PayNumber + '\'' +
                    '}';
        }

        public String getAgentShopNumberCount() {
            return AgentShopNumberCount;
        }

        public String getManyPayNumberCount() {
            return ManyPayNumberCount;
        }

        public String getAgentShopNumber() {
            return AgentShopNumber;
        }

        public String getManyPayNumber() {
            return ManyPayNumber;
        }

        public String getTelNumber() {
            return TelNumber;
        }

        public String getPayNumber() {
            return PayNumber;
        }
    }

    /**
     * 甲方
     */
    public static class CustomerArrData implements Serializable {
        private String companyId;
        private String CompanyName;
        private String CompanyLogoUrl;

        private List<ProjectArrData> ProjectArr;

        @Override
        public String toString() {
            return "CustomerArrData{" +
                    "companyId='" + companyId + '\'' +
                    ", CompanyName='" + CompanyName + '\'' +
                    ", CompanyLogoUrl='" + CompanyLogoUrl + '\'' +
                    ", ProjectArr=" + ProjectArr +
                    '}';
        }

        public String getCompanyId() {
            return companyId;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public String getCompanyLogoUrl() {
            return CompanyLogoUrl;
        }

        public List<ProjectArrData> getProjectArr() {
            return ProjectArr;
        }
    }
    /**
     * 甲方列表的详情
     */
    public static class ProjectArrData implements Serializable {
        private String id;
        private String ProjectName;

        @Override
        public String toString() {
            return "ProjectArrData{" +
                    "id='" + id + '\'' +
                    ", ProjectName='" + ProjectName + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public String getProjectName() {
            return ProjectName;
        }
    }

    /**
     * 甲方
     */
    public static class Company_InfoData implements Serializable {
        private String CompanyName;

        public String getCompanyName() {
            return CompanyName;
        }

        @Override
        public String toString() {
            return "Company_InfoData{" +
                    "CompanyName='" + CompanyName + '\'' +
                    '}';
        }
    }

    /**
     * 名片
     */
    public static class NameCardInfoData implements Serializable {


        private boolean IsMyProject;
        private String NameCardType;
        private String NameCardTitle;
        private String LogoUrl;
        private String RecommandReason;
        private String Qualifications;
        private String ContactsTrueName;
        private String ContactsMobile;
        private String ContactsPhone;
        private String ContactsEmail;
        private String ContactsPosition;
        private String ContactsDescription;
        private boolean HasContactsBuy;
        private int CityNum;
        private int StoreNum;
        private String CreatorId;
        private String id;
        private String UserId;
        private List<CustomerArrData> CustomerArr;
        private ExtendsPrototypesData ExtendsPrototypes;
        private List<PageStarResult> ProjectInfoArr;

        public boolean isMyProject() {
            return IsMyProject;
        }

        public String getUserId() {
            return UserId;
        }

        public List<PageStarResult> getProjectInfoArr() {
            return ProjectInfoArr;
        }

        public String getContactsDescription() {
            return ContactsDescription;
        }

        public boolean isHasContactsBuy() {
            return HasContactsBuy;
        }

        public ExtendsPrototypesData getExtendsPrototypes() {
            return ExtendsPrototypes;
        }

        public List<CustomerArrData> getCustomerArr() {
            return CustomerArr;
        }

        @Override
        public String toString() {
            return "NameCardInfoData{" +
                    "NameCardType='" + NameCardType + '\'' +
                    ", NameCardTitle='" + NameCardTitle + '\'' +
                    ", LogoUrl='" + LogoUrl + '\'' +
                    ", RecommandReason='" + RecommandReason + '\'' +
                    ", Qualifications='" + Qualifications + '\'' +
                    ", ContactsTrueName='" + ContactsTrueName + '\'' +
                    ", ContactsMobile='" + ContactsMobile + '\'' +
                    ", ContactsPhone='" + ContactsPhone + '\'' +
                    ", ContactsEmail='" + ContactsEmail + '\'' +
                    ", ContactsPosition='" + ContactsPosition + '\'' +
                    ", CityNum=" + CityNum +
                    ", StoreNum=" + StoreNum +
                    ", CreatorId='" + CreatorId + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        public String getNameCardType() {
            return NameCardType;
        }

        public String getNameCardTitle() {
            return NameCardTitle;
        }

        public String getLogoUrl() {
            return LogoUrl;
        }

        public String getRecommandReason() {
            return RecommandReason;
        }

        public String getQualifications() {
            return Qualifications;
        }

        public String getContactsTrueName() {
            return ContactsTrueName;
        }

        public String getContactsMobile() {
            return ContactsMobile;
        }

        public String getContactsPhone() {
            return ContactsPhone;
        }

        public String getContactsEmail() {
            return ContactsEmail;
        }

        public String getContactsPosition() {
            return ContactsPosition;
        }

        public int getCityNum() {
            return CityNum;
        }

        public int getStoreNum() {
            return StoreNum;
        }

        public String getCreatorId() {
            return CreatorId;
        }

        public String getId() {
            return id;
        }
    }
}
